/*
 * This file is part of Total Economy, licensed under the MIT License (MIT).
 *
 * Copyright (c) Eric Grandt <https://www.ericgrandt.com>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.erigitic.jobs;

import ninja.leaping.configurate.ConfigurationNode;

import java.math.BigDecimal;
import java.util.Optional;

public class TEActionReward {
    private String action;
    private String targetID;
    private int expReward;
    private BigDecimal moneyReward;
    private String growthTrait;
    private Integer growthMeta;

    private boolean isValid = false;

    public TEActionReward(String action, String targetID, String expReward, String moneyReward, String growthTrait) {
        this.action = action;
        this.targetID = targetID;
        this.expReward = Integer.parseInt(expReward);
        this.moneyReward = new BigDecimal(moneyReward);
        this.growthTrait = growthTrait;

        isValid = (action != null && !action.isEmpty() && targetID != null && !targetID.isEmpty());
    }

    public String getAction() {
        return action;
    }

    public String getTargetID() {
        return targetID;
    }

    public int getExpReward() {
        return expReward;
    }

    public BigDecimal getMoneyReward() {
        return moneyReward;
    }

    public boolean isValid() {
        return isValid;
    }

    public Optional<String> getGrowthTrait() {
        return Optional.ofNullable(growthTrait);
    }
}
