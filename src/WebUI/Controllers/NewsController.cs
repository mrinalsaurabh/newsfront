using Microsoft.AspNet.Mvc;
using System;
using System.Collections.Generic;
using WebUI.Entities;
using System.Threading.Tasks;

namespace WebUI.Controllers
{
    public class NewsController : Controller
    {
        public IActionResult NewNews()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Save(NewsItem newsItem)
        {
            if (ModelState.IsValid)
                return RedirectToAction("Index", "Home", "");
            else
                return View("NewNews");
        }
    }
}
