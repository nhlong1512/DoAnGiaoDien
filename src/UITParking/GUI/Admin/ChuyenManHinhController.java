/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UITParking.GUI.Admin;

import static UITParking.GUI.HomepageAdmin.kindSelectedPublic;
import UITParking.GUI.Admin.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = kindSelectedPublic;

    private ArrayList<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) throws Exception {
        switch (kindSelectedPublic) {
            case "QLKH": {
                jpnItem.setBackground(new Color(220, 148, 34));
                jlbItem.setBackground(new Color(220, 148, 34));

                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new QLKHJPanel());
                root.validate();
                root.repaint();
            }
            break;
            case "QLNV": {
                jpnItem.setBackground(new Color(220, 148, 34));
                jlbItem.setBackground(new Color(220, 148, 34));

                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new QLNVJPanel());
                root.validate();
                root.repaint();
            }
            break;
            case "QLV": {
                jpnItem.setBackground(new Color(220, 148, 34));
                jlbItem.setBackground(new Color(220, 148, 34));

                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new QLVJPanel());
                root.validate();
                root.repaint();
            }
            break;
            case "QLX": {
                jpnItem.setBackground(new Color(220, 148, 34));
                jlbItem.setBackground(new Color(220, 148, 34));

                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new QLXJPanel());
                root.validate();
                root.repaint();
            }
            break;

            case "QLKVL": {
                jpnItem.setBackground(new Color(220, 148, 34));
                jlbItem.setBackground(new Color(220, 148, 34));

                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new QLKVLJPanel());
                root.validate();
                root.repaint();
            }
            break;

            case "QLHD": {
                jpnItem.setBackground(new Color(220, 148, 34));
                jlbItem.setBackground(new Color(220, 148, 34));

                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new QLHDJPanel());
                root.validate();
                root.repaint();
            }
            break;

            case "BCTK": {
                jpnItem.setBackground(new Color(220, 148, 34));
                jlbItem.setBackground(new Color(220, 148, 34));

                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new BCTKJPanel());
                root.validate();
                root.repaint();
            }
            break;
            case "QLXRV": {
                jpnItem.setBackground(new Color(220, 148, 34));
                jlbItem.setBackground(new Color(220, 148, 34));

                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new QLXRVJPanel());
                root.validate();
                root.repaint();
            }
            break;

            default: {
                jpnItem.setBackground(new Color(220, 148, 34));
                jlbItem.setBackground(new Color(220, 148, 34));

                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new QLKHJPanel());
                root.validate();
                root.repaint();
            }
            break;
        }
    }

    public void setEvent(ArrayList<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
            item.getJpn().addMouseListener(new PanelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class PanelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public PanelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "QLKH": {
                    try {
                        node = new QLKHJPanel();
                    } catch (Exception ex) {
                        Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "QLNV": {
                    try {
                        node = new QLNVJPanel();
                    } catch (Exception ex) {
                        Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "QLV": {
                    try {
                        node = new QLVJPanel();
                    } catch (Exception ex) {
                        Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "QLX": {
                    try {
                        node = new QLXJPanel();
                    } catch (Exception ex) {
                        Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "QLKVL": {
                    try {
                        node = new QLKVLJPanel();
                    } catch (Exception ex) {
                        Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "QLHD": {
                    try {
                        node = new QLHDJPanel();
                    } catch (Exception ex) {
                        Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case "BCTK":
                    {
                    try {
                        node = new BCTKJPanel();
                    } catch (Exception ex) {
                        Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                case "QLXRV":
                {
                    try {
                        node = new QLXRVJPanel();
                    } catch (Exception ex) {
                        Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;


                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            kindSelected = kind;
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            jpnItem.setBackground(new Color(220, 148, 34));
            jlbItem.setBackground(new Color(220, 148, 34));

        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(220, 148, 34));
            jlbItem.setBackground(new Color(220, 148, 34));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(255, 255, 255));
                jlbItem.setBackground(new Color(255, 255, 255));

            }
        }

        private void setChangeBackground(String kind) {
            for (DanhMucBean item : listItem) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getJpn().setBackground(new Color(220, 148, 34));
                    item.getJlb().setBackground(new Color(220, 148, 34));
                } else {
                    item.getJpn().setBackground(new Color(255, 255, 255));
                    item.getJlb().setBackground(new Color(255, 255, 255));

                }
            }
        }

    }
}
