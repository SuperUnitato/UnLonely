package com.SuperUnitato.UnLonely.blocks;

import java.util.List;

import com.SuperUnitato.UnLonely.Reference;
import com.SuperUnitato.UnLonely.UnLonely;
import com.SuperUnitato.UnLonely.client.gui.AtmMain;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAtm extends Block implements ITileEntityProvider {
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625*2,0,0.0625*2,.0624*14,.0625*13,.0625*14);

	public BlockAtm() {
		
		super(Material.IRON);
		setUnlocalizedName(Reference.UnLonelyBlocks.ATM.getUnlocalizedName());
		setRegistryName(Reference.UnLonelyBlocks.ATM.getRegistryName());
		
		setHardness(10.0F);
		setResistance(50.0F);
		setLightLevel(0.6F);
		
		setCreativeTab(UnLonely.tabUnLonely);
		
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return BOUNDING_BOX;
	}
	
		
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean p_185477_7_) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
        	Minecraft.getMinecraft().displayGuiScreen(new AtmMain());
        	
         }
        
		return true;
		
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return null;
	}
}
