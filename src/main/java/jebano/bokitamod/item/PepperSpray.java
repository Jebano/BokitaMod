package jebano.bokitamod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class PepperSpray extends Item {
	public PepperSpray(Item.Properties properties) {
		super(properties.maxDamage(20));
	}
	
	   public boolean itemInteractionForEntity(ItemStack stack, World worldIn, net.minecraft.entity.player.PlayerEntity playerIn, LivingEntity entity, net.minecraft.util.Hand hand) {
	         if (entity.world.isRemote) return false;
	         if (entity instanceof LivingEntity) {
	        	 entity.addPotionEffect(new EffectInstance(Effects.POISON, 100));
	        	 entity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 100));
	        	 entity.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 20));
	            if (stack.getMaxDamage() - stack.getDamage() >= 1) {
	               stack.damageItem(1, playerIn, (e) -> {e.sendBreakAnimation(hand);});}
	         }

	         worldIn.playSound(playerIn, playerIn.getPosition(), SoundEvents.ENTITY_CREEPER_HURT, SoundCategory.PLAYERS, 0.8F, 0.8F);
	         playerIn.getCooldownTracker().setCooldown(this, 30);
	 		 playerIn.swingArm(hand);
	 		 playerIn.setActiveHand(hand);
	 		 playerIn.addStat(Stats.ITEM_USED.get(this));
			return true;
	      }
	   }
	