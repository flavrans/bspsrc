/*
** 2011 April 5
**
** The author disclaims copyright to this source code.  In place of
** a legal notice, here is a blessing:
**    May you do good and not evil.
**    May you find forgiveness for yourself and forgive others.
**    May you share freely, never taking more than you give.
*/

package info.ata4.bspsrc.modules.texture;

import info.ata4.bsplib.struct.DTexData;

/**
 * A simple texture data structure.
 * 
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class Texture {

    private DTexData data;
    private String texture;
    private String textureOverride;
    private TextureAxis u = new TextureAxis(1, 0, 0);
    private TextureAxis v = new TextureAxis(0, 1, 0);
    private int lmscale = 16;

    public TextureAxis getUAxis() {
        return u;
    }

    public void setUAxis(TextureAxis u) {
        this.u = u;
    }

    public TextureAxis getVAxis() {
        return v;
    }

    public void setVAxis(TextureAxis v) {
        this.v = v;
    }

    public String getTexture() {
        return textureOverride != null ? textureOverride : texture;
    }

    public String getOriginalTexture() {
        return texture;
    }

    public void setOriginalTexture(String texture) {
        this.texture = texture;
    }

    public String getOverrideTexture() {
        return textureOverride;
    }

    public void setOverrideTexture(String texture) {
        this.textureOverride = texture;
    }

    public int getLightmapScale() {
        return lmscale;
    }

    public void setLightmapScale(int lmscale) {
        this.lmscale = lmscale;
    }

    public DTexData getData() {
        return data;
    }

    public void setData(DTexData texdata) {
        this.data = texdata;
    }

    public boolean isToolTexture() {
        if (getTexture() != null) {
            switch(getTexture()) {
                case ToolTexture.NODRAW:
                case ToolTexture.CLIP:
                case ToolTexture.BLOCKLIGHT:
                case ToolTexture.PLAYERCLIP:
                case ToolTexture.SKIP:
                case ToolTexture.TRIGGER:
                case ToolTexture.SKYBOX:
                case ToolTexture.AREAPORTAL:
                case ToolTexture.INVIS:
                case ToolTexture.HINT:
                case ToolTexture.NPCCLIP:
                case ToolTexture.BLACK:
                case ToolTexture.CSGO_GRENADECLIP:
                case ToolTexture.BLOCKBULLETS:
                case ToolTexture.OCCLUDER:
                case ToolTexture.BLOCKLOS:
                case ToolTexture.CSGO_DRONECLIP:
                case ToolTexture.WHITE:
                case ToolTexture.DOTTED:
                case ToolTexture.INVISLADDER:
                    return true;
                default:
                    return false;
            }
        } else {
            return false;
        }
    }
}
