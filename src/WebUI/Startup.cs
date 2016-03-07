using Microsoft.AspNet.Authentication.Google;
using Microsoft.AspNet.Builder;
using Microsoft.AspNet.Hosting;
using Microsoft.AspNet.Http;
using Microsoft.Extensions.DependencyInjection;

namespace WebUI
{
    public class Startup
    {
        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit http://go.microsoft.com/fwlink/?LinkID=398940
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddMvc();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app)
        {
            app.UseIISPlatformHandler();
            app.UseFileServer();
            var options = new GoogleOptions()
            {
                ClientId = "245948545456-g9vnvp8d8ogsko7gqa2mhlk3ndlcud4v.apps.googleusercontent.com",
                ClientSecret = "FcVMQSXk50OcEh5W4IMIOGpi",
                AuthenticationScheme = "Google",
                SignInScheme = "Bearer"

            };

            app.UseGoogleAuthentication(options);
            app.UseMvc(routes =>
            {
                routes.MapRoute(
                    name: "default",
                    template: "{controller=Home}/{action=Index}/{id?}");
            });
        }

        // Entry point for the application.
        public static void Main(string[] args) => WebApplication.Run<Startup>(args);
    }
}
