﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookStore.Services.MessageTypes
{
    public class Order : MessageType
    {
        public Order()
        {
            OrderItems = new List<OrderItem>();
        }

        public List<OrderItem> OrderItems { get; set; }
        public decimal Total { get; set; }
        public System.DateTime OrderDate { get; set; }
        public int Status { get; set; }
        public User Customer {get;set;}
    }
}
