using Microsoft.AspNet.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebUI.Controllers
{
    public class UserController : Controller
    {
        public ActionResult UserProfile()
        {
            return View();
        }
    }
}
