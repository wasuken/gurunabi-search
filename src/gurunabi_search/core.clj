(ns gurunabi-search.core
  (:require [config.core :refer [env]])
  (:require [clojure.data.json :as json])
  (:require [ring.util.codec :as codec])
  (:gen-class))

(def base-url "https://api.gnavi.co.jp/")

(def api-categories {:rest "RestSearchAPI"
                     :photo "PhotoSearchAPI"
                     :area "AreaSearchAPI"
                     :foreign "ForeignRestSearchAPI"
                     :master {:area "AreaSearchAPI"
                              :pref "PrefSearchAPI"
                              :area-l "GAreaLargeSearchAPI"
                              :area-m "GAreaMiddleSearchAPI"
                              :area-s "GAreaSmallSearchAPI"
                              :category-area-l "CategoryLargeSearchAPI"
                              :category-area-s "CategorySmallSearchAPI"
                              }
                     }
  )

(def url-version "v3")

(defn create-api-url
  [categories params-str] (str base-url categories "/" url-version "/?" params-str))

(defn create-params
  [& key-values] (cond
                   (= (mod (count key-values) 2) 0)
                   (reduce str (map (fn [x] (str (first x) "=" (second x)))
                                    (partition 2 key-values)))))

(defn -main
  []
  (println (create-api-url (:area (:master api-categories))
                           (create-params "freeword" (codec/url-encode "寿司")))))

;; (defrecord restSearchAPIRequest [keyid id name name_kana tel address area pref areacode_l areacode_m areacode_s category_l category_s input_coordinates_mode coordinates_mode latitude longitude range sort offset hit_per_page offset_page freeword freeword_condition lunch no_smoking card mobilephone bottomless_cup sunday_open takeout private_room midnight parking memorial_service birthday_privilege betrothal_present kids_menu outret wifi microphone buffet late_lunch sports until_morning lunch_desert projecter_screen with_pet deliverly special_holiday_lunch e_money caterling breakfast desert_buffet lunch_buffet bento lunch_salad_buffet darts web_reserve])
