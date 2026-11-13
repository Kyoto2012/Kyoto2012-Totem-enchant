package com.kyoto.totemench;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantable;

/**
 * Totem Enchanting.
 *
 * Vanilla only lets items with the ENCHANTABLE component go in the enchanting
 * table, and the totem doesn't have one. We give it one here (value 15 = about
 * iron-tier luck). The item tags in data/minecraft/tags/item/enchantable decide
 * WHICH enchantments it can get (Unbreaking, Mending, Curse of Vanishing).
 */
public class TotemEnchant implements ModInitializer {

    public static final String MOD_ID = "totemench";

    /** How enchantable the totem is in the table. Higher = better rolls. */
    private static final int TOTEM_ENCHANTABILITY = 15;

    @Override
    public void onInitialize() {
        DefaultItemComponentEvents.MODIFY.register(context ->
            context.modify(Items.TOTEM_OF_UNDYING, builder ->
                builder.set(DataComponents.ENCHANTABLE, new Enchantable(TOTEM_ENCHANTABILITY))
            )
        );
    }
}
