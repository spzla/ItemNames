package me.spzla.itemnames.mixin;

import me.spzla.itemnames.ItemNames;
import me.spzla.itemnames.access.ItemStackAccessor;
import net.minecraft.component.ComponentHolder;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;
import java.util.Objects;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements ComponentHolder {

    @Shadow
    public abstract Item getItem();

    @Inject(method = "getTooltip", at = @At(value = "INVOKE_ASSIGN", target = "Ljava/util/List;add(Ljava/lang/Object;)Z"), locals = LocalCapture.CAPTURE_FAILSOFT)
    public void itemnames$getTooltip(Item.TooltipContext context, PlayerEntity player, TooltipType type, CallbackInfoReturnable<List<Text>> cir, List<Text> list) {
        if (this.contains(DataComponentTypes.CUSTOM_NAME) || this.contains(DataComponentTypes.ITEM_NAME)) {
            if (this.contains(DataComponentTypes.CUSTOM_NAME) && this.contains(DataComponentTypes.ITEM_NAME)) {
                MutableText text = (MutableText) this.getOrDefault(DataComponentTypes.ITEM_NAME, Text.empty());
                text.formatted(Formatting.DARK_GRAY);
                list.add(text);
            }

            MutableText text = (MutableText) this.getItem().getName();
            text.formatted(Formatting.DARK_GRAY);
            list.add(text);
        }
    }
}
