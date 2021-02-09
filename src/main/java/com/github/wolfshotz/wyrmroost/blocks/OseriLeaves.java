package com.github.wolfshotz.wyrmroost.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class OseriLeaves extends Block
{
    public OseriLeaves(Properties properties)
    {
        super(properties);
    }

    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random rand)
    {
        if (rand.nextDouble() < 0.1 && world.getBlockState(pos = pos.down()).isAir())
        {
            // todo: make falling petals?
            world.addParticle(ParticleTypes.DRIPPING_HONEY, pos.getX(), pos.getY() + 0.9, pos.getZ(), 0, 0, 0);
        }
    }
}