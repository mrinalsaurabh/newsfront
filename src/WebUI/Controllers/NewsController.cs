using Microsoft.AspNet.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
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
        public IActionResult Save(string Data)
        {
            Console.WriteLine(Data);
            return RedirectToAction("Index","Home","");
        }
    }
}
