package recursivity

import scala.annotation.tailrec

object CountChange {

  def countChange(money: Int, coins: List[Int], compteur: Int = 0): Int = {
    
    if (money == 0 && compteur != 0) 1
    else if (!coins.isEmpty && money > 0) countChange(money - coins.head, coins, 1) + countChange(money, coins.tail, 1)
    else 0
  }

}