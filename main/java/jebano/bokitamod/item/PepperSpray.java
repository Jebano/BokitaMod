package jebano.bokitamod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;

public class PepperSpray extends Item {
	public PepperSpray(Item.Properties properties) {
		super(properties.maxDamage(20));
	}
	
	   @Override
	   public boolean itemInteractionForEntity(ItemStack stack, net.minecraft.entity.player.PlayerEntity playerIn, LivingEntity entity, net.minecraft.util.Hand hand) {
	         if (entity.world.isRemote) return false;
	         if (entity instanceof LivingEntity) {
	        	 entity.addPotionEffect(new EffectInstance(Effects.POISON, 100));
	        	 entity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 100));
	        	 entity.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 20));
	            if (stack.getMaxDamage() - stack.getDamage() >= 1) {
	               stack.damageItem(1, playerIn, (e) -> {e.sendBreakAnimation(hand);});
	               if (stack.isEmpty()) {
	                  ItemStack stack1 = new ItemStack(Items.EMPTY_PEPPER_SPRAY);
	                  stack1.setTag(stack.getTag());
	               }
	            }
	         }

	         playerIn.addStat(Stats.ITEM_USED.get(this));
			return true;
	      }
	   }
	