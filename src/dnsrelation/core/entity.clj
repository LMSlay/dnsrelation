(ns dnsrelation.core.entity
  (:require [dnsrelation.core.database :as db]
            [clojure.set :as set]))

;; base logic

(defn union-property
  [a b property]
  (set/difference (db/get-link a property) (db/get-link b property))
  )

(defn transitive-property
  [a b property]
  (map (fn [x] ((partial db/add-link b) x property)) (union-property a b property))
)

;; relation function

(def map-entity
  (let [fi-node ["own-by" "control-by"]]
    (fn [start end]
      (map (partial transitive-property a b) fi-node)
      )
    )
  )