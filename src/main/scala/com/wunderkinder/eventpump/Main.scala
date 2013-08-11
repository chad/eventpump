package com.wunderkinder.eventpump {
  import akka.actor.ReceiveTimeout
  import akka.actor.Actor
  import akka.actor._
  import scala.concurrent.duration._
  import scala.util.Random

  class Notifications(person: String) extends Actor {
    var messages = List[String]()

    context.setReceiveTimeout(3 seconds)

    def receive = {
      case message:String => messages = messages ++ List[String](message)
      case ReceiveTimeout => {
        println(person + " got: " + messages.mkString(","))
        messages = List[String]()
      }
    }
  }

  object Main extends App {
    val s = ActorSystem("messages")
    val first = s.actorOf(Props(classOf[Notifications], "chad"), "user123")
    val second = s.actorOf(Props(classOf[Notifications], "daniel"), "user321")

    val actors = Array(first, second)
    1 to 1000 foreach { x =>
      Random.shuffle(actors.toList).head !  "hello " + x
      Thread.sleep(Random.nextInt(1000))
    }
  }
}
