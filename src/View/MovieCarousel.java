package View;

import Logic.DoubleLinkedList.LinkedList;
import Logic.Movie.Movie;
import Logic.Movie.MovieGenreLists;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

public class MovieCarousel extends JPanel {

    private MovieGenreLists movieGenreLists;

    public MovieCarousel() {
        setLayout(new BorderLayout());

        movieGenreLists = new MovieGenreLists();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.DARK_GRAY);

        String[] categories = {"ImgCienciaFiccion", "ImgDisparos", "ImgDocumentales", "ImgTerror"};
        for (String category : categories) {
            mainPanel.add(createCategoryPanel(category));
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(255, 165, 0));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.addActionListener(e -> {
            JFContainer c = new JFContainer();
            TvOrStreamJP tvors = new TvOrStreamJP();
            tvors.setSize(c.InitialJP.getSize());
            this.removeAll();
            this.add(tvors);
            this.revalidate();
            this.repaint();
        });

        JPanel backPanel = new JPanel();
        backPanel.setBackground(Color.DARK_GRAY);
        backPanel.add(backButton);

        add(backPanel, BorderLayout.SOUTH);
    }

    private JPanel createCategoryPanel(String category) {
        JPanel categoryPanel = new JPanel(new BorderLayout());
        categoryPanel.setBackground(Color.DARK_GRAY);

        String displayCategory = category.replace("Img", "");
        JLabel headerLabel = new JLabel(displayCategory);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        categoryPanel.add(headerLabel, BorderLayout.NORTH);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        imagePanel.setBackground(Color.DARK_GRAY);

        List<JLabel> localImageLabels = new ArrayList<>();

        String[] images = getImagesForCategory(category);
        LinkedList moviesList = movieGenreLists.getMoviesInGenre(displayCategory.toLowerCase());

        Logic.DoubleLinkedList.Node current = moviesList.start;
        int i = 0;
        while (current != null && i < images.length) {
            final Logic.DoubleLinkedList.Node movieNode = current;
            ImageIcon icon = createImageIcon("/" + category + "/" + images[i]);
            if (icon != null) {
                JLabel imageLabel = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
                imageLabel.setToolTipText(((Movie) movieNode.element).getTitle() + " (" + ((Movie) movieNode.element).getYear() + ")");
                imageLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        showMovieDetails((Movie) movieNode.element);
                    }
                });
                imagePanel.add(imageLabel);
                localImageLabels.add(imageLabel);
            }
            current = current.next;
            i++;
        }

        JButton prevButton = new JButton("<");
        JButton nextButton = new JButton(">");

        prevButton.setBackground(new Color(255, 165, 0));
        prevButton.setForeground(Color.WHITE);
        prevButton.setFocusPainted(false);
        prevButton.setBorderPainted(false);

        nextButton.setBackground(new Color(255, 165, 0));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.setBorderPainted(false);

        prevButton.addActionListener(e -> scrollImages(imagePanel, localImageLabels, -1));
        nextButton.addActionListener(e -> scrollImages(imagePanel, localImageLabels, 1));

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.add(prevButton, BorderLayout.WEST);
        buttonPanel.add(nextButton, BorderLayout.EAST);

        JPanel combinedPanel = new JPanel(new BorderLayout());
        combinedPanel.add(prevButton, BorderLayout.WEST);
        combinedPanel.add(imagePanel, BorderLayout.CENTER);
        combinedPanel.add(nextButton, BorderLayout.EAST);
        combinedPanel.setBackground(Color.DARK_GRAY);

        categoryPanel.add(combinedPanel, BorderLayout.CENTER);

        return categoryPanel;
    }

    private void scrollImages(JPanel imagePanel, List<JLabel> imageLabels, int direction) {
        if (imageLabels.isEmpty()) {
            return;
        }

        JLabel label = direction > 0 ? imageLabels.remove(0) : imageLabels.remove(imageLabels.size() - 1);
        if (direction > 0) {
            imageLabels.add(label);
        } else {
            imageLabels.add(0, label);
        }

        imagePanel.removeAll();
        for (JLabel imageLabel : imageLabels) {
            imagePanel.add(imageLabel);
        }

        imagePanel.revalidate();
        imagePanel.repaint();
    }

    private ImageIcon createImageIcon(String path) {
        URL imgURL = getClass().getResource(path);
        System.out.println("Error: " + imgURL);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Error: " + path);
            return null;
        }
    }

    private String[] getImagesForCategory(String category) {
        switch (category) {
            case "ImgCienciaFiccion":
                return new String[]{"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg"};
            case "ImgDisparos":
                return new String[]{"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg"};
            case "ImgDocumentales":
                return new String[]{"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg"};
            case "ImgTerror":
                return new String[]{"1.jpg", "2.png", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg"};
            default:
                return new String[]{}; // Empty array if no match
        }
    }

    private void showMovieDetails(Movie movie) {
        removeAll();
        StreamJP streamJP = new StreamJP();
        streamJP.setMovieDetails(movie);
        add(streamJP);
        revalidate();
        repaint();
    }
}
