using System.ComponentModel.DataAnnotations;

namespace News.Web.Entities
{
    public class NewsItem
    {
        public int Id { get; set; }
        public string Author { get; set; }
        [Required]
        public string Heading { get; set; }
        [Required]
        public string Date { get; set; }
        [Required]
        public string Body { get; set; }
    }
}
