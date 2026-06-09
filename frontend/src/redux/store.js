import { configureStore } from '@reduxjs/toolkit'; import auth from './slices/authSlice'; import products from './slices/productSlice'; import player from './slices/playerSlice'; import ui from './slices/uiSlice';
export const store = configureStore({ reducer:{ auth, products, player, ui } });
