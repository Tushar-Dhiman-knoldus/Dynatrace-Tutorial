import akka.actor.{Actor, ActorLogging, ActorSystem, Kill, PoisonPill, Props}
import org.apache.logging.log4j.ThreadContext

class PoisonPillExample extends Actor with ActorLogging {
  def receive: Receive = {
    case "start" =>
      log.info("Actor started")
    case "process" =>
      log.error("Error Message Log")
    case "stop" =>
      self ! PoisonPill
  }
}

object Test extends App{

  val system = ActorSystem("MySystem")
  val actor = system.actorOf(Props[PoisonPillExample], "PoisonPillExample")

  actor ! "start"
  for (_ <- 1 to 100) {
    actor ! "process"
    Thread.sleep(10000)
  }
  actor ! "stop"

}
