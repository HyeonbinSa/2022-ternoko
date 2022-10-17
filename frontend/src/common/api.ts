import axios from 'axios';

import LocalStorage from './localStorage';
import { CommentRequestBodyType, MemberExtendedRoleType } from './types/domain';

const accessToken = LocalStorage.getAccessToken();

if (accessToken) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${accessToken}`;
}

export const deleteCrewInterviewAPI = (interviewId: number) =>
  axios.delete(`${process.env.SERVER_URL}/api/interviews/${interviewId}`);

export const getUserStatusAPI = (code: string, redirectUrl: string) =>
  axios.get(`${process.env.SERVER_URL}/api/login?code=${code}&redirectUrl=${redirectUrl}`);

export const getDuplicatedNicknameStatusAPI = (nickname: string) =>
  axios.get(`${process.env.SERVER_URL}/api/login/check?nickname=${nickname}`);

export const validateAccessTokenAPI = (type: MemberExtendedRoleType) =>
  axios.get(`${process.env.SERVER_URL}/api/login/valid?type=${type}`);

export const postCommentAPI = (interviewId: number, body: CommentRequestBodyType) =>
  axios.post(`${process.env.SERVER_URL}/api/interviews/${interviewId}/comments`, body);

export const getCommentAPI = (interviewId: number) =>
  axios.get(`${process.env.SERVER_URL}/api/interviews/${interviewId}/comments`);

export const putCommentAPI = (
  interviewId: number,
  commentId: number,
  body: CommentRequestBodyType,
) =>
  axios.put(`${process.env.SERVER_URL}/api/interviews/${interviewId}/comments/${commentId}`, body);
