/*
 ** 2011 September 25
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package info.ata4.bsplib.struct;

import info.ata4.io.DataInputReader;
import info.ata4.io.DataOutputWriter;
import java.io.IOException;

/**
 * DFace variant for Vampire: The Masquerade – Bloodlines
 * 
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class DFaceVTMB extends DFace {
    
    public static final int MAXLIGHTMAPS = 8;
    
    public int[] avgLightColor = new int[MAXLIGHTMAPS];
    public byte[] styles = new byte[MAXLIGHTMAPS];	// lighting info
    public byte[] day = new byte[MAXLIGHTMAPS];		// Nightime lightmapping system
    public byte[] night = new byte[MAXLIGHTMAPS];	// Nightime lightmapping system
    
    @Override
    public int getSize() {
        return 104;
    }

    @Override
    public void read(DataInputReader in) throws IOException {
        for (int i = 0; i < MAXLIGHTMAPS; i++) {
            avgLightColor[i] = in.readInt();
        }
        
        pnum = in.readUnsignedShort();
        side = in.readByte();
        onnode = in.readByte();
        fstedge = in.readInt();
        numedge = in.readShort();
        texinfo = in.readShort();
        dispInfo = in.readShort();
        surfaceFogVolumeID = in.readUnsignedShort();
        in.readFully(styles);
        in.readFully(day);
        in.readFully(night);
        lightofs = in.readInt();
        area = in.readFloat();
        lightmapTextureMinsInLuxels[0] = in.readInt();
        lightmapTextureMinsInLuxels[1] = in.readInt();
        lightmapTextureSizeInLuxels[0] = in.readInt();
        lightmapTextureSizeInLuxels[1] = in.readInt();
        origFace = in.readInt();
        smoothingGroups = in.readInt();
    }

    @Override
    public void write(DataOutputWriter out) throws IOException {
        for (int i = 0; i < MAXLIGHTMAPS; i++) {
           out.writeInt(avgLightColor[i]);
        }
        
        out.writeShort(pnum);
        out.writeByte(side);
        out.writeByte(onnode);
        out.writeInt(fstedge);
        out.writeShort(numedge);
        out.writeShort(texinfo);
        out.writeShort(dispInfo);
        out.writeShort(surfaceFogVolumeID);
        out.write(styles);
        out.write(day);
        out.write(night);
        out.writeInt(lightofs);
        out.writeFloat(area);
        out.writeInt(lightmapTextureMinsInLuxels[0]);
        out.writeInt(lightmapTextureMinsInLuxels[1]);
        out.writeInt(lightmapTextureSizeInLuxels[0]);
        out.writeInt(lightmapTextureSizeInLuxels[1]);
        out.writeInt(origFace);
        out.writeShort(firstPrimID);
        out.writeShort(numPrims);
        out.writeInt(smoothingGroups);
    }
}
