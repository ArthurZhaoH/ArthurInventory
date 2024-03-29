﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using BookStore.WebClient.ClientModels;
using BookStore.WebClient.ViewModels;

namespace BookStore.WebClient
{
    public class CartModelBinder : IModelBinder
    {
        private const String cartSessionKey = "_cart";

        public object BindModel(ControllerContext controllerContext, ModelBindingContext bindingContext)
        {
            if (bindingContext.Model != null)
                throw new InvalidOperationException("Cannot update instances");

            Cart lCart = (Cart)controllerContext.HttpContext.Session[cartSessionKey];
            if (lCart == null)
            {
                lCart = new Cart();
                controllerContext.HttpContext.Session[cartSessionKey] = lCart;
            }
            return lCart;
        }

        public static void ClearCartBinder(HttpSessionStateBase pSession)
        {
            Cart lCart = pSession[cartSessionKey] as Cart;
            if(lCart != null)
            {
                lCart.Clear();
            }
        }
    }
}