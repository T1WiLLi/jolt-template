package jolt.template.controller;

import io.github.t1willi.annotations.Controller;
import io.github.t1willi.annotations.Get;
import io.github.t1willi.annotations.Query;
import io.github.t1willi.core.MvcController;
import io.github.t1willi.http.ModelView;
import io.github.t1willi.http.ResponseEntity;
import io.github.t1willi.localization.LanguageService;
import io.github.t1willi.utils.Flash;

/**
 * Le controlleur de base pour les templates. Il fournit les méthodes pour
 * afficher les templates.
 * Si vous ne voulez pas utiliser le système de language, vous pouvez retirer
 * les vérifications de langue.
 * 
 */
@Controller
public class HomeController extends MvcController {

    @Get
    public ResponseEntity<ModelView> index() {
        return render("index", null);
    }

    @Get("/change-lang")
    public ResponseEntity<Void> changeLang(@Query String lang) {
        if (lang.equals("en") || lang.equals("fr")) {
            LanguageService.changeLanguage(lang);
            Flash.success(lang.equals("fr") ? "La langue a été changée en français" : "Language changed to English");
        } else {
            Flash.error(LanguageService.getCurrentLanguage().equals("fr") ? "La langue n'est pas prise en charge"
                    : "Language not supported");
        }
        return redirect("/");
    }

    @Get("/*")
    public ResponseEntity<Void> catch404() {
        String path = super.context.rawPath();
        Flash.error(LanguageService.getCurrentLanguage().equals("fr") ? "La page " +
                path + " n'existe pas"
                : "Page " + path + " not found");
        return redirect("/");
    }
}