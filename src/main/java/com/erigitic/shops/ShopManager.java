package com.erigitic.shops;

import com.erigitic.main.TotalEconomy;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.property.SlotIndex;
import org.spongepowered.api.item.inventory.transaction.SlotTransaction;

public class ShopManager {

    private TotalEconomy totalEconomy;
    private Logger logger;

    public ShopManager(TotalEconomy totalEconomy) {
        this.totalEconomy = totalEconomy;

        logger = totalEconomy.getLogger();
    }

    @Listener
    public void onInventoryClick(ClickInventoryEvent event) {
        Inventory inventory = event.getTargetInventory();
        String itemNameOriginal = event.getCursorTransaction().getOriginal().getType().getName(); // On drop
        String itemNameDefault = event.getCursorTransaction().getDefault().getType().getName(); // On pickup
        String itemNameFinal = event.getCursorTransaction().getFinal().getType().getName(); // On pickup

        logger.info(itemNameOriginal);
        logger.info(itemNameDefault);
        logger.info(itemNameFinal);

        int upperSize = inventory.iterator().next().capacity();

        for (SlotTransaction transaction : event.getTransactions()) {
            int affectedSlot = transaction.getSlot().getProperty(SlotIndex.class, "slotindex").map(SlotIndex::getValue).orElse(-1);
            boolean upperInventory = affectedSlot != -1 && affectedSlot < upperSize;

            logger.info("" + upperInventory);
        }
    }

}