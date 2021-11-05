package ru.raspberry
import com.pi4j.Pi4J
import com.pi4j.io.i2c.{I2C, I2CProvider}

import scala.util.Try

object RaspberryMain extends App {
//
//  private val OLED091_REG_ADDR_OUT_PORT = 0x01
//  private val OLED091_REG_ADDR_CFG = 0x03

  val pi4j = Pi4J.newAutoContext()
  val i2CProvider: I2CProvider = pi4j.provider("linuxfs-i2c")
  val i2CConfig = I2C.newConfigBuilder(pi4j).id("oled091").bus(1).device(0x3f).build()
  Try {
    val oled091 = i2CProvider.create(i2CConfig)
    var reg_addr = 0x00
    while(reg_addr < 0xff) {
      val config = oled091.readRegister(reg_addr)
      if (config < 0 ) println(s"Failed to read configuration at $reg_addr")
      else println(s"Success to read configuration at $reg_addr : $config")
      reg_addr += 1
    }
  }.fold(
    e => throw new IllegalStateException(e.getMessage),
    identity
  )

  println("Hello, Raspberry!")

}
