// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.ColorFlowAnimation;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.StrobeAnimation;
import com.ctre.phoenix.led.CANdle.LEDStripType;
import com.ctre.phoenix.led.ColorFlowAnimation.Direction;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LED extends SubsystemBase {
  /** Creates a new LED. */
  CANdle candle;
  CANdleConfiguration config;
  RainbowAnimation rainbowAnim;
  StrobeAnimation strobeAnim;
  ColorFlowAnimation flowAnim;
  Direction direction;
  public LED() {
    direction = Direction.Forward;
    candle = new CANdle(3);
    config = new CANdleConfiguration();
    config.stripType = LEDStripType.RGB;
    candle.configAllSettings(config);
    rainbowAnim = new RainbowAnimation(1, .25, 68);
    strobeAnim = new StrobeAnimation(128, 0, 255, 0, .01, 68, 0);
    flowAnim = new ColorFlowAnimation(150, 30, 0, 0, .5, 68, direction, 0);

    candle.setLEDs(0, 0, 0);
  }
  public void RedAnim() {
    candle.setLEDs(255, 0, 0);
  }

  public void GreenAnim() {
    candle.setLEDs(0, 255, 0);
  }

  public void BlueAnim() {
    candle.setLEDs(0, 0, 255);
  }

  public void RainbowAnim() {
    candle.animate(rainbowAnim, 0);
  }

  public void StrobeAnim() {
    candle.animate(strobeAnim, 1);
  }
  public void FlowAnim() {
    candle.animate(flowAnim, 2);
  }

  public void NoAnim() {
    candle.setLEDs(0, 0, 0);
    candle.clearAnimation(0);
    candle.clearAnimation(1);
    candle.clearAnimation(2);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
