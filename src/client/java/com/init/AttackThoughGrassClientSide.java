//他目前的运作方式是玩家手持武器时，截获选择器返回的干扰方块返回值，欺骗选择器选择后方的方块，这是我能想到的效果比较好的方案了
//后续，我会把方块和武器定义迁移到配置文件。另外，他并不是一个成品，而是半成品，稳定性有待商榷

//大饼：1.将武器与干扰方块配置迁移到配置文件夹中，这将使mod中的武器可用，2.添加方块状态判断，3.无实体时重新激活干扰方块选择，4.在游戏内添加该功能开关

package com.init;

import net.fabricmc.api.ClientModInitializer;

public class AttackThoughGrassClientSide implements ClientModInitializer {
	public static StringBuilder[] blocksAllowedToIgnore;
	public static StringBuilder[] weapon ;
	public static boolean contain(StringBuilder[] stringBuilders, StringBuilder stringBuilder)
	{
        for (StringBuilder builder : stringBuilders) {
            if (stringBuilder.compareTo(builder) == 0)
                return true;
        }
		return false;
	}
	@Override
	public void onInitializeClient() {
		//这里看起来很糟糕，但很庆幸他能工作，注意正确的内存分配，否则会导致空指针异常
		//我希望这里能写好点，但为了赶工不得不这样做，下个版本使用较好的方案，但是目前不能。我希望你能提供帮助。
		//我并不保证他工作正常
		weapon = new StringBuilder[14];
		blocksAllowedToIgnore = new StringBuilder[17];

		weapon[0] = new StringBuilder("minecraft:wooden_sword");
		weapon[1] = new StringBuilder("minecraft:stone_sword");
		weapon[2] = new StringBuilder("minecraft:iron_sword");
		weapon[3] = new StringBuilder("minecraft:golden_sword");
		weapon[4] = new StringBuilder("minecraft:diamond_sword");
		weapon[5] = new StringBuilder("minecraft:netherite_sword");
		weapon[6] = new StringBuilder("minecraft:wooden_axe");
		weapon[7] = new StringBuilder("minecraft:stone_axe");
		weapon[8] = new StringBuilder("minecraft:iron_axe");
		weapon[9] = new StringBuilder("minecraft:golden_axe");
		weapon[10] = new StringBuilder("minecraft:diamond_axe");
		weapon[11] = new StringBuilder("minecraft:netherite_axe");
		weapon[12] = new StringBuilder("minecraft:trident");
		weapon[13] = new StringBuilder("minecraft:mace");
		//这里只包含一些典型的坑人方块
		//祝您玩的开心
		blocksAllowedToIgnore[0] = new StringBuilder("Block{"+"minecraft:tall_grass"+"}");
		blocksAllowedToIgnore[1] = new StringBuilder("Block{"+"minecraft:short_grass"+"}");
		blocksAllowedToIgnore[2] = new StringBuilder("Block{"+"minecraft:fern"+"}");
		blocksAllowedToIgnore[3] = new StringBuilder("Block{"+"minecraft:short_dry_grass"+"}");
		blocksAllowedToIgnore[4] = new StringBuilder("Block{"+"minecraft:bush"+"}");
		blocksAllowedToIgnore[5] = new StringBuilder("Block{"+"minecraft:dead_bush"+"}");
		blocksAllowedToIgnore[6] = new StringBuilder("Block{"+"minecraft:dandelion"+"}");
		blocksAllowedToIgnore[7] = new StringBuilder("Block{"+"minecraft:weeping_vines"+"}");
		blocksAllowedToIgnore[8] = new StringBuilder("Block{"+"minecraft:weeping_vines_plant"+"}");
		blocksAllowedToIgnore[9] = new StringBuilder("Block{"+"minecraft:sugar_cane"+"}");
		blocksAllowedToIgnore[10] = new StringBuilder("Block{"+"minecraft:twisting_vines"+"}");
		blocksAllowedToIgnore[11] = new StringBuilder("Block{"+"minecraft:vine"+"}");
		blocksAllowedToIgnore[12] = new StringBuilder("Block{"+"minecraft:sunflower"+"}");
		blocksAllowedToIgnore[13] = new StringBuilder("Block{"+"minecraft:lilac"+"}");
		blocksAllowedToIgnore[14] = new StringBuilder("Block{"+"minecraft:rose_bush"+"}");
		blocksAllowedToIgnore[15] = new StringBuilder("Block{"+"minecraft:peony"+"}");
		blocksAllowedToIgnore[16] = new StringBuilder("Block{"+"minecraft:pale_hanging_moss"+"}");
	}
}
