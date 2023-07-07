package com.redhat.parodos.examples.vmonboarding.checker;

import java.util.UUID;

import com.redhat.parodos.examples.base.BaseWorkFlowCheckerTaskTest;
import com.redhat.parodos.tasks.ansible.AapGetJobResponseDTO;
import com.redhat.parodos.utils.RestUtils;
import com.redhat.parodos.workflow.exception.MissingParameterException;
import com.redhat.parodos.workflow.task.checker.BaseWorkFlowCheckerTask;
import com.redhat.parodos.workflow.utils.WorkContextUtils;
import com.redhat.parodos.workflows.work.WorkContext;
import com.redhat.parodos.workflows.work.WorkReport;
import com.redhat.parodos.workflows.work.WorkStatus;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;

import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.spy;

public class AnsibleJobCompletionWorkFlowCheckerTaskTest extends BaseWorkFlowCheckerTaskTest {

	private static final String SERVICE_URL_TEST = "service-url-test";

	private static final String USERNAME_TEST = "username-test";

	private static final String PASSWORD_TEST = "password-test";

	private static final String JOB_ID_PARAMETER_NAME = "JOB_ID";

	private static final String JOB_ID_PARAMETER_VALUE_TEST = "job-id-test";

	private static final String AAP_GET_JOB_RESPONSE_DTO_STATUS_PENDING_TEST = "pending";

	private AnsibleJobCompletionWorkFlowCheckerTask ansibleJobCompletionWorkFlowCheckerTask;

	@Before
	public void setUp() {
		this.ansibleJobCompletionWorkFlowCheckerTask = spy(
				(AnsibleJobCompletionWorkFlowCheckerTask) getConcretePersonImplementation());
		try {
			doReturn(JOB_ID_PARAMETER_VALUE_TEST).when(this.ansibleJobCompletionWorkFlowCheckerTask)
					.getRequiredParameterValue(eq(JOB_ID_PARAMETER_NAME));
		}
		catch (MissingParameterException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected BaseWorkFlowCheckerTask getConcretePersonImplementation() {
		return new AnsibleJobCompletionWorkFlowCheckerTask(SERVICE_URL_TEST, USERNAME_TEST, PASSWORD_TEST);
	}

	@Test
	public void executePending() {
		// given
		try (MockedStatic<RestUtils> restUtilsMockedStatic = mockStatic(RestUtils.class)) {
			restUtilsMockedStatic.when(
					() -> RestUtils.restExchange(any(), any(String.class), any(String.class), any(String.class), any()))
					.thenReturn(ResponseEntity.ok(AapGetJobResponseDTO.builder()
							.status(AAP_GET_JOB_RESPONSE_DTO_STATUS_PENDING_TEST).build()));
			// when
			WorkContext workContext = new WorkContext();
			WorkContextUtils.setMainExecutionId(workContext, UUID.randomUUID());
			ansibleJobCompletionWorkFlowCheckerTask.setBeanName("test");
			ansibleJobCompletionWorkFlowCheckerTask.preExecute(workContext);
			WorkReport workReport = ansibleJobCompletionWorkFlowCheckerTask.checkWorkFlowStatus(workContext);

			// then
			assertEquals(WorkStatus.REJECTED, workReport.getStatus());
		}
	}

	@Test
	public void executeRejected() {
		// given
		try (MockedStatic<RestUtils> restUtilsMockedStatic = mockStatic(RestUtils.class)) {
			restUtilsMockedStatic.when(
					() -> RestUtils.restExchange(any(), any(String.class), any(String.class), any(String.class), any()))
					.thenReturn(ResponseEntity.ok(AapGetJobResponseDTO.builder().status("").build()));
			// when
			WorkContext workContext = new WorkContext();
			WorkContextUtils.setMainExecutionId(workContext, UUID.randomUUID());
			ansibleJobCompletionWorkFlowCheckerTask.setBeanName("test");
			ansibleJobCompletionWorkFlowCheckerTask.preExecute(workContext);
			WorkReport workReport = ansibleJobCompletionWorkFlowCheckerTask.checkWorkFlowStatus(workContext);

			// then
			assertEquals(WorkStatus.REJECTED, workReport.getStatus());
		}
	}

	@Test
	public void executeFail() {
		// given
		try (MockedStatic<RestUtils> restUtilsMockedStatic = mockStatic(RestUtils.class)) {
			restUtilsMockedStatic.when(
					() -> RestUtils.restExchange(any(), any(String.class), any(String.class), any(String.class), any()))
					.thenReturn(ResponseEntity.internalServerError().build());

			// when
			WorkContext workContext = new WorkContext();
			WorkContextUtils.setMainExecutionId(workContext, UUID.randomUUID());
			ansibleJobCompletionWorkFlowCheckerTask.setBeanName("test");
			ansibleJobCompletionWorkFlowCheckerTask.preExecute(workContext);
			WorkReport workReport = ansibleJobCompletionWorkFlowCheckerTask.checkWorkFlowStatus(workContext);

			// then
			assertEquals(WorkStatus.REJECTED, workReport.getStatus());
		}
	}

}
