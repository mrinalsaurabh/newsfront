using System;
using System.Collections.Generic;
using News.Web.Entities;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace News.Web.Controllers
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
