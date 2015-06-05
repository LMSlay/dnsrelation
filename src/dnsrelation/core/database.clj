(ns dnsrelation.core.database
  (:require [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.relationships :as nrl]
            [clojurewerkz.neocons.rest.nodes :as nn]))

(def conn  (nr/connect "http://localhost:7474/db/data/"))

(defn search-repeat
  [dns index]
  (let [result (nn/query conn index (str index ":" dns))]
    (if (empty? result)
      nil
      (:id ((into [] result) 1))
      )
    ))

(defn create-dns
  [dns index]
  (let [node (nn/create conn dns)]
    (nn/add-to-index conn (:id node) index index domain)
    node
    )
  )

(defn create-doamin-ip
  [doamin ip]
  (let [d (create-dns domain "domain")
       i (nn/create ip "ip")]
  (nrl/create conn d i :map)
    )
  )

