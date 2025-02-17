/*
 * Parodos Workflow Service API
 * This is the API documentation for the Parodos Workflow Service. It provides operations to execute assessments to determine infrastructure options (tooling + environments). Also executes infrastructure task workflows to call downstream systems to stand-up an infrastructure option.
 *
 * The version of the OpenAPI document: v1.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.redhat.parodos.sdk.model;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.redhat.parodos.sdk.invoker.JSON;

/**
 * AccessRequestDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class AccessRequestDTO {

	/**
	 * Gets or Sets role
	 */
	@JsonAdapter(RoleEnum.Adapter.class)
	public enum RoleEnum {

		OWNER("OWNER"),

		DEVELOPER("DEVELOPER"),

		ADMIN("ADMIN");

		private String value;

		RoleEnum(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static RoleEnum fromValue(String value) {
			for (RoleEnum b : RoleEnum.values()) {
				if (b.value.equals(value)) {
					return b;
				}
			}
			throw new IllegalArgumentException("Unexpected value '" + value + "'");
		}

		public static class Adapter extends TypeAdapter<RoleEnum> {

			@Override
			public void write(final JsonWriter jsonWriter, final RoleEnum enumeration) throws IOException {
				jsonWriter.value(enumeration.getValue());
			}

			@Override
			public RoleEnum read(final JsonReader jsonReader) throws IOException {
				String value = jsonReader.nextString();
				return RoleEnum.fromValue(value);
			}

		}

	}

	public static final String SERIALIZED_NAME_ROLE = "role";

	@SerializedName(SERIALIZED_NAME_ROLE)
	private RoleEnum role;

	public static final String SERIALIZED_NAME_USERNAME = "username";

	@SerializedName(SERIALIZED_NAME_USERNAME)
	private String username;

	public AccessRequestDTO() {
	}

	public AccessRequestDTO role(RoleEnum role) {

		this.role = role;
		return this;
	}

	/**
	 * Get role
	 * @return role
	 **/
	@javax.annotation.Nullable
	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public AccessRequestDTO username(String username) {

		this.username = username;
		return this;
	}

	/**
	 * Get username
	 * @return username
	 **/
	@javax.annotation.Nullable
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AccessRequestDTO accessRequestDTO = (AccessRequestDTO) o;
		return Objects.equals(this.role, accessRequestDTO.role)
				&& Objects.equals(this.username, accessRequestDTO.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(role, username);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AccessRequestDTO {\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
		sb.append("    username: ").append(toIndentedString(username)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the
	 * first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public static HashSet<String> openapiFields;

	public static HashSet<String> openapiRequiredFields;

	static {
		// a set of all properties/fields (JSON key names)
		openapiFields = new HashSet<String>();
		openapiFields.add("role");
		openapiFields.add("username");

		// a set of required properties/fields (JSON key names)
		openapiRequiredFields = new HashSet<String>();
	}

	/**
	 * Validates the JSON Object and throws an exception if issues found
	 * @param jsonObj JSON Object
	 * @throws IOException if the JSON Object is invalid with respect to AccessRequestDTO
	 */
	public static void validateJsonObject(JsonObject jsonObj) throws IOException {
		if (jsonObj == null) {
			if (!AccessRequestDTO.openapiRequiredFields.isEmpty()) { // has required
																		// fields but JSON
																		// object is null
				throw new IllegalArgumentException(String.format(
						"The required field(s) %s in AccessRequestDTO is not found in the empty JSON string",
						AccessRequestDTO.openapiRequiredFields.toString()));
			}
		}

		Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
		// check to see if the JSON string contains additional fields
		for (Entry<String, JsonElement> entry : entries) {
			if (!AccessRequestDTO.openapiFields.contains(entry.getKey())) {
				throw new IllegalArgumentException(String.format(
						"The field `%s` in the JSON string is not defined in the `AccessRequestDTO` properties. JSON: %s",
						entry.getKey(), jsonObj.toString()));
			}
		}
		if ((jsonObj.get("role") != null && !jsonObj.get("role").isJsonNull())
				&& !jsonObj.get("role").isJsonPrimitive()) {
			throw new IllegalArgumentException(
					String.format("Expected the field `role` to be a primitive type in the JSON string but got `%s`",
							jsonObj.get("role").toString()));
		}
		if ((jsonObj.get("username") != null && !jsonObj.get("username").isJsonNull())
				&& !jsonObj.get("username").isJsonPrimitive()) {
			throw new IllegalArgumentException(String.format(
					"Expected the field `username` to be a primitive type in the JSON string but got `%s`",
					jsonObj.get("username").toString()));
		}
	}

	public static class CustomTypeAdapterFactory implements TypeAdapterFactory {

		@SuppressWarnings("unchecked")
		@Override
		public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
			if (!AccessRequestDTO.class.isAssignableFrom(type.getRawType())) {
				return null; // this class only serializes 'AccessRequestDTO' and its
								// subtypes
			}
			final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
			final TypeAdapter<AccessRequestDTO> thisAdapter = gson.getDelegateAdapter(this,
					TypeToken.get(AccessRequestDTO.class));

			return (TypeAdapter<T>) new TypeAdapter<AccessRequestDTO>() {
				@Override
				public void write(JsonWriter out, AccessRequestDTO value) throws IOException {
					JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
					elementAdapter.write(out, obj);
				}

				@Override
				public AccessRequestDTO read(JsonReader in) throws IOException {
					JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
					validateJsonObject(jsonObj);
					return thisAdapter.fromJsonTree(jsonObj);
				}

			}.nullSafe();
		}

	}

	/**
	 * Create an instance of AccessRequestDTO given an JSON string
	 * @param jsonString JSON string
	 * @return An instance of AccessRequestDTO
	 * @throws IOException if the JSON string is invalid with respect to AccessRequestDTO
	 */
	public static AccessRequestDTO fromJson(String jsonString) throws IOException {
		return JSON.getGson().fromJson(jsonString, AccessRequestDTO.class);
	}

	/**
	 * Convert an instance of AccessRequestDTO to an JSON string
	 * @return JSON string
	 */
	public String toJson() {
		return JSON.getGson().toJson(this);
	}

}
