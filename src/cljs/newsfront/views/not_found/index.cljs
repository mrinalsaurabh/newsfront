(ns newsfront.views.not-found.index)

(defn page []
    [:div {:class "body"}
    [:h2 "You've found a secret page."]
    [:h3 "You probably dont want to be here. You're lost. Try goinig back"]
    [:a {:href "/"} "home"]
    [:h3 "?"]])