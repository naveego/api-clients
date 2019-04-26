package log

import org.apache.logging.log4j.LogManager


trait LazyLogger {
  @transient lazy val log = LogManager.getLogger(getClass)
}
