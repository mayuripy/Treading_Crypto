package com.sit.trading.model;

import com.sit.trading.Enums.verificationType;

import lombok.Data;

@Data
public class TwoFactoreAuto {
    private boolean isEnabled =false;
    private verificationType sendTo;
}
