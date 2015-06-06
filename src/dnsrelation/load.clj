(ns dnsrelation.load
  (require [clojure.string :as str]
    [dnsrelation.core.database :as db]))

;; data example: www.baidu.com,127.0.0.1
(def path ["dataset/10086.txt" "dataset/sub.txt" "dataset/main.txt"])


(defn dns-hash
  [dns]
  (str/join " "(map str (vec dns)))
  )

(defn dns-deal-test
  [dns]
  (let [x (str/split dns #",")]
    (let [d (into [] x)]
      (db/create-domain-ip (d 0) (d 1))
      )
    )
  )

(defn data-load
  [path deal]
  (with-open [rdr (clojure.java.io/reader path)]
    (loop [x (count (line-seq rdr))]
      (when (> x 0)
        ((fn [x] (deal x)) (line-seq rdr)))
      (recur (- x 1)))
    )
  )

(defn data-load-smail
  [path deal]
  (with-open [rdr (clojure.java.io/reader path)]
    (doseq [line (line-seq rdr)]
      (deal line)))
  )

(defn -main
  [& args]
  ;; creates a node wit two properties
  (data-load-smail (str "/Users/slay/project/clojure/dnsrelation/src/dnsrelation/" (path 0)) dns-deal-test)
;;  (db/create-domain-ip "wwwwww" "hhhhh")
  )