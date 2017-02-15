package recursivity

import scala.annotation.tailrec

object Parenthesis {

  def balance(chars: List[Char], compteur: Int = 0): Boolean = {
    // TODO : implement here the algorith to check if the parenthesis are balanced

    /*
    //println(s"$chars $compteur")
    if (compteur < 0) {
      //println("comteur<0")
      false
    } else {
      if (chars.isEmpty && compteur == 0) {
        //println("comteur==0 et chars vide")
        true
      } else {
        if (chars.head == '(') {
          balance(chars.tail, compteur + 1)
        } else {
          if (chars.head == ')') {
            balance(chars.tail, compteur - 1)
          } else {
            balance(chars.tail,compteur)
          }
        }
      }
    }*/

    if (compteur < 0) false
    else if (chars.isEmpty && compteur == 0) true
    else if (chars.head == '(') balance(chars.tail, compteur + 1)
    else if (chars.head == ')') balance(chars.tail, compteur - 1)
    else balance(chars.tail, compteur)

  }
}