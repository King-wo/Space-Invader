# MoteurDeJeu


## Code source

- Le code source se trouve directement dans ce dépôt.
- Il est possible d'ouvrir le dossier à la racine directement dans [Netbeans](https://netbeans.apache.org)

## Objectif

- Faire un clone du moteur de jeu sur son ordinateur :
```
git clone https://gitlab.univ-lorraine.fr/villard5/moteurdejeu.git
```
- Compiler la bibliothèque ``moteurDeJeu.jar``
- Faire votre jeu en utilisant cette bibliothèque
- Utiliser le [git](https://gitlab.univ-lorraine.fr/) de l'université de lorraine comme gestionnaire de version

## Exemples des années passées

| Projet | Video |
| :------------------: | :-------------------: |
| Space invader  | ![](invader.mp4) |

## Build

Compile the sources and package the game engine along with the images in
`resources/` into a JAR:

```bash
mkdir -p build/classes
javac -d build/classes $(find . -name '*.java')
jar cf moteurDeJeu.jar -C build/classes . -C resources .
```

The `-C resources .` part ensures `hero.png`, `monstre.png` and the
background image are included on the classpath.
