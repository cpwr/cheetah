(ns cheetah.state)

(def state (atom {:rooms [
                          ["#general" "general"]
                          ["#random" "random"]
                          ["#dev-js" "dev-js"]]
                  :user nil
                  :route nil}))
