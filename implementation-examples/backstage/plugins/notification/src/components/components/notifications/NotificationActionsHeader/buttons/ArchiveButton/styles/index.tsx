/*
 *  Copyright (c) 2022 Red Hat Developer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

/**
 * @author Richard Wang (Github: RichardW98)
 */

import styled, { css } from 'styled-components';
import MuiArchiveIcon from '@material-ui/icons/Archive';

const iconStyles = css`
  && {
    font-size: 25px;
    color: ${({ disabled }) => (disabled ? 'rgba(0, 0, 0, 0.26)' : '#2A2A2A')};
  }
`;

export const ArchiveIcon = styled(MuiArchiveIcon)`
  ${iconStyles}
`;
