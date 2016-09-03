using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace News.Web.Controllers
{
    public class UserController : Controller
    {
        public ActionResult UserProfile()
        {
            return View();
        }
    }
}
