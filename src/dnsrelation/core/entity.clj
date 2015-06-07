(ns dnsrelation.core.entity
  (:require [dnsrelation.core.database :as db]))

(def map-entity
  (let [fi-key [:status :ip]
        fi-node ["own-by"]]
    (fn [start end]
      (db/prop-set start end)
      (db/add-link start end)
      )
    )
  )

