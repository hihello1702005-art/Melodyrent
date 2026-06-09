import { createSlice } from '@reduxjs/toolkit';
const slice=createSlice({name:'ui',initialState:{dark:false,notifications:[]},reducers:{toggleDark:s=>{s.dark=!s.dark;document.documentElement.classList.toggle('dark',s.dark)},pushNotification:(s,a)=>{s.notifications.unshift(a.payload)}}});
export const {toggleDark,pushNotification}=slice.actions; export default slice.reducer;
