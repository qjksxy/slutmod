package sluot.bread.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sluot.bread.entity.effect.ModStatusEffects;
import sluot.bread.item.ModItems;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "onDeath", at = @At("HEAD"))
    private void onDeath(DamageSource damageSource, CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        Entity entity = damageSource.getAttacker();
        // 检查是否为玩家击杀生物
        if (entity instanceof PlayerEntity playerEntity) {
            Item item = playerEntity.getEquippedStack(EquipmentSlot.MAINHAND).getItem();
            if(item == ModItems.SIWANGZHIWU) {
                if (!playerEntity.hasStatusEffect(ModStatusEffects.SIWANG)) {
                    return;
                }
                int duration;
                StatusEffectInstance statusEffect = playerEntity.getStatusEffect(ModStatusEffects.SIWANG);
                assert statusEffect != null;
                duration = statusEffect.getDuration();
                // 至多免除 30 秒的凋零伤害, 不会持续恢复生命
                if(duration < 400) {
                    playerEntity.removeStatusEffect(ModStatusEffects.SIWANG);
                } else {
                    playerEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.SIWANG, (duration - 400), 1));
                }
            }
        }
    }
}
