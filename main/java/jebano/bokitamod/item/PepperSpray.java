package jebano.bokitamod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;

public class PepperSpray extends Item {
	public PepperSpray(Item.Properties properties) {
		super(properties.maxDamage(20));
	}

	   @Override
	   public boolean itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, net.minecraft.util.Hand hand) {
		   if (target.world.isRemote) return false;
	         if (target instanceof LivingEntity) {
	        	 target.addPotionEffect(new EffectInstance(Effects.POISON, 40));
	        	 target.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 125));
	        	 target.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 20));
	        	 stack.damageItem(1, target, e -> e.sendBreakAnimation(hand));
	        	 if (stack.isEmpty()) {
	                 stack = new ItemStack(Items.ARROW);
	              }
	         }

	        playerIn.getEntityWorld().playSound(null, playerIn.getPosition(), SoundEvents.ENTITY_CREEPER_HURT, SoundCategory.PLAYERS, 0.9f, 3.0f);
	        playerIn.swingArm(hand);
	 		playerIn.setActiveHand(hand);
	 		playerIn.addStat(Stats.ITEM_USED.get(this));
			return true;
	      }
	   
}