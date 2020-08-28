package kill.trump.game.map;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kill.trump.game.model.Block;
import kill.trump.game.model.World;

public class MapReader {

    public static World getWorldFromFile(FileHandle mapFileHandle) {

        World world = new World();

        if (mapFileHandle.exists()){
            String mapFileStr = mapFileHandle.readString();
            String[] strings = mapFileStr.split(";");
            String str1, str2;

            Pattern blockPositionPattern = Pattern.compile("\\[(\\d+),(\\d+)\\]", Pattern.CASE_INSENSITIVE);
            Pattern worldSizePattern = Pattern.compile("width=(\\d+) height=(\\d+)", Pattern.CASE_INSENSITIVE);

            for (String str : strings){
                Matcher blockPositionMatcher = blockPositionPattern.matcher(str);
                Matcher worldSizeMatcher = worldSizePattern.matcher(str);

                while (worldSizeMatcher.find()){
                    world.width = Integer.parseInt(worldSizeMatcher.group(1));
                    world.height = Integer.parseInt(worldSizeMatcher.group(2));
                }

                while (blockPositionMatcher.find()){
                    str1 = blockPositionMatcher.group(1);
                    str2 = blockPositionMatcher.group(2);

                    int id = Integer.parseInt(str.trim().substring(0,1));

                    world.block = (Block) world.blocks.getBlockWithID(id).clone();
                    world.block.setPosition(new Vector2(Integer.parseInt(str1), Integer.parseInt(str2)));
                    world.blocksArray.add(world.block);
                }
            }

            return world;

        }

        return world;

    }

}
