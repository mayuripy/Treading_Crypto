package com.sit.model;

import com.sit.Enums.verificationType;

import lombok.Data;

@Data
public class TwoFactoreAuto {
    private boolean isEnabled =false;
    private verificationType sendTo;
}
