import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'; import { api } from '../../services/api';
export const login = createAsyncThunk('auth/login', async (payload) => (await api.post('/auth/login', payload)).data);
const slice=createSlice({ name:'auth', initialState:{ user: JSON.parse(localStorage.getItem('melodyrent_user')||'null'), token: localStorage.getItem('melodyrent_token') }, reducers:{ logout(s){s.user=null;s.token=null;localStorage.clear()} }, extraReducers:b=>b.addCase(login.fulfilled,(s,a)=>{s.user=a.payload.user;s.token=a.payload.accessToken;localStorage.setItem('melodyrent_token',a.payload.accessToken);localStorage.setItem('melodyrent_user',JSON.stringify(a.payload.user));}) });
export const { logout }=slice.actions; export default slice.reducer;
