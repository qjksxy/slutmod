package slut.bread.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import slut.bread.item.SLUTModItems;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(at = @At("HEAD"), method = "applyDamage", cancellable = true)
    protected void applyDamage(DamageSource source, float amount, CallbackInfo ci) {
        PlayerEntity playerEntity = (PlayerEntity) (Object) this;
        ItemStack itemStack = playerEntity.getEquippedStack(EquipmentSlot.MAINHAND);
        Item item = itemStack.getItem();
        boolean isWither = source.isOf(DamageTypes.WITHER);
        // 只有其他生物造成的伤害才会触发，摔落伤害、岩浆伤害等不会触发
        boolean attackByLivingEntity = source.getAttacker() instanceof LivingEntity;
        if (item == SLUTModItems.SiWangZhiWu && !isWither && attackByLivingEntity) {
            int duration = 0;
            if (playerEntity.hasStatusEffect(StatusEffects.WITHER)) {
                StatusEffectInstance statusEffect = playerEntity.getStatusEffect(StatusEffects.WITHER);
                assert statusEffect != null;
                duration = statusEffect.getDuration();
            }
            playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, (int)(duration + amount * 20), 0));
            ci.cancel();
        }
    }
}