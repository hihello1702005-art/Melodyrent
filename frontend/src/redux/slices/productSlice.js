import { createAsyncThunk, createSlice } from '@reduxjs/toolkit'; import { api } from '../../services/api';
export const fetchProducts=createAsyncThunk('products/fetch', async (params={}) => (await api.get('/products',{params})).data);
export const fetchRecommendations=createAsyncThunk('products/recommendations', async () => (await api.get('/recommendations')).data);
const slice=createSlice({name:'products',initialState:{items:[],recommendations:[],status:'idle',query:''},reducers:{setQuery:(s,a)=>{s.query=a.payload}},extraReducers:b=>b.addCase(fetchProducts.pending,s=>{s.status='loading'}).addCase(fetchProducts.fulfilled,(s,a)=>{s.status='ready';s.items=a.payload.content||[]}).addCase(fetchRecommendations.fulfilled,(s,a)=>{s.recommendations=a.payload})});
export const {setQuery}=slice.actions; export default slice.reducer;
