package config

import com.typesafe.config.{Config, ConfigFactory}

trait Configurations {

  val config: Config = ConfigFactory.load

  val dbProfile: String = config.getString("db.config.host")
  val dbDriver: String = config.getString("db.config.driver")

}