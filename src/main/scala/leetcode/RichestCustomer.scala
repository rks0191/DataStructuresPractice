package leetcode

//case class RichestCustomerProblem() {
//  def getRichestCustomer(accountDetails:Seq[Seq[Int]]):Int ={
//    accountDetails.foldLeft(0){
//      (maxSalary,accountRow) =>
//        val updatedSalary = accountRow.reduceLeft(_+_)
//        if (updatedSalary > maxSalary) updatedSalary else maxSalary
//    }
//  }
//}
//object RichestCustomerProblem{
//  def main(args: Array[String]): Unit = {
//    val customerGuy = Seq(Seq(7,1,3),Seq(2,8,7),Seq(1,9,5))
//    val customer = RichestCustomerProblem().getRichestCustomer(customerGuy)
//    print(customer)
//  }
//}
/**
 * Do the same thing in a more object oriented problem
 *
 * */

sealed trait Bank {
 def bankName:String
}
object Bank1 extends Bank{
  override def bankName: String = "Bank1"
}
object Bank2 extends Bank{
  override def bankName: String = "Bank2"
}
object Bank3 extends Bank{
  override def bankName: String = "Bank3"
}

case class Customer(customerName:String,bankName:Bank,balance:Int)
object Customer{
  def getRichestCustomer(customer1:Customer,customer2:Customer):Customer={
    if(customer1.balance > customer2.balance) customer1 else customer2
  }
}
case class RichestCustomer(customer:Customer)

case class Customers(customers:Seq[Customer])

case class RichestBank(bankName:String,bankBalance:Int,numberOfCustomers:Int)
object RichestBank{
  def getRichestBank(bank1:RichestBank,bank2:RichestBank):RichestBank ={
    if(bank1.bankBalance > bank2.bankBalance) bank1 else bank2
  }
}
object Customers{
  def getRichestCustomer(customers: Customers):RichestCustomer={
    val groupedCustomerView: Seq[Customer] =customers.customers.map{
      customer => customer.customerName -> customer
    }.groupBy(_._1)
      .map{ case (customer,customersTuple) =>
        customersTuple.map(_._2).foldLeft(Customer(customer,Bank1,0)){
          (customerInitialized,customer) =>
            Customer(customer.customerName,customer.bankName,customer.balance+customerInitialized.balance)
        }
    }.toSeq
    val richestCustomer = groupedCustomerView.reduceLeft(Customer.getRichestCustomer(_,_))
    RichestCustomer(richestCustomer)
  }
  def getBestBank(customers:Customers):RichestBank={
    val groupedBankView =customers.customers.map{
      customer => customer.bankName -> customer
    }.groupBy(_._1).map{
      case (_,bankTuple) => bankTuple.map(_._2).foldLeft(RichestBank("",0,0)){
        (bank,tuple) =>RichestBank(tuple.bankName.bankName,bank.bankBalance+tuple.balance,bank.numberOfCustomers + 1)
      }
    }.toSeq
    groupedBankView.reduceLeft(RichestBank.getRichestBank(_,_))
  }
}
object RichestCustomer{

  def main(args: Array[String]): Unit = {
    val customer1 = Customer("customer1",Bank1,7)
    val customer2 = Customer("customer1",Bank2,1)
    val customer3 = Customer("customer1",Bank3,3)
    val customer4 = Customer("customer2",Bank1,2)
    val customer5 = Customer("customer2",Bank2,8)
    val customer6 = Customer("customer2",Bank3,7)
    val customer7 = Customer("customer3",Bank1,1)
    val customer8 = Customer("customer3",Bank2,9)
    val customer9 = Customer("customer3",Bank3,5)
    val allCustomers = Customers(Seq(customer1,customer2,customer3,customer4,customer5,customer6,customer7,customer8,customer9))
    val richestCustomer = Customers.getRichestCustomer(allCustomers)
    val bestBank = Customers.getBestBank(allCustomers)
    print(richestCustomer)
    print(bestBank)
  }
}