package Area

import org.apache.log4j.Logger
import org.apache.log4j.spi.LoggerRepository

object Demolog extends App{
val logger=Logger.getLogger(this.getClass)
  logger.error("this is information")
}
